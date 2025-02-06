import React, { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [acomodacoes, setAcomodacoes] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [searchCity, setSearchCity] = useState("");
  const [favorites, setFavorites] = useState(() => {
    const saved = localStorage.getItem("favoriteAcomodacoes");
    return saved ? JSON.parse(saved) : [];
  });
  const [viewFavorites, setViewFavorites] = useState(false); // Estado para controlar a visualização

  useEffect(() => {
    localStorage.setItem("favoriteAcomodacoes", JSON.stringify(favorites));
  }, [favorites]);

  const fetchAcomodacoes = async (city = "") => {
    setLoading(true);
    setError(null);
    try {
      let url = "http://localhost:8080/get-acomodacoes";

      if (city.trim()) {
        const normalizedCity = city.trim().toLowerCase();
        url = `http://localhost:8080/get-acomodacoes-for-city?city=${encodeURIComponent(
          normalizedCity
        )}`;
      }

      const response = await fetch(url);
      if (!response.ok) {
        throw new Error("Erro ao buscar acomodações");
      }
      const data = await response.json();
      setAcomodacoes(data);
    } catch (error) {
      setError(error.message);
    }
    setLoading(false);
  };

  const handleToggleFavorite = (id) => {
    setFavorites((prev) =>
      prev.includes(id) ? prev.filter((fId) => fId !== id) : [...prev, id]
    );
  };

  const handleSearch = () => {
    fetchAcomodacoes(searchCity);
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleSearch();
    }
  };

  useEffect(() => {
    fetchAcomodacoes();
  }, []);

  const handleShowFavorites = () => {
    setViewFavorites(true); // Mostrar favoritos
  };

  const handleShowAll = () => {
    setViewFavorites(false); // Mostrar lista completa
  };

  const filteredAcomodacoes = viewFavorites
    ? acomodacoes.filter((item) => favorites.includes(item.id))
    : acomodacoes;

  return (
    <div className="App">
      <header className="App-header">
        <h1>Acomodações</h1>

        <div style={{ margin: "20px 0" }}>
          <input
            type="text"
            placeholder="Pesquisar por cidade..."
            value={searchCity}
            onChange={(e) => setSearchCity(e.target.value)}
            onKeyPress={handleKeyPress}
            style={{
              padding: "10px",
              fontSize: "16px",
              marginRight: "10px",
              width: "300px",
            }}
          />
          <button
            onClick={handleSearch}
            style={{
              padding: "10px 20px",
              fontSize: "16px",
              backgroundColor: "#4CAF50",
              color: "white",
              border: "none",
              borderRadius: "4px",
              cursor: "pointer",
            }}
          >
            Pesquisar
          </button>
        </div>

        {loading && <p>Carregando...</p>}
        {error && <p style={{ color: "red" }}>{error}</p>}

        <div style={{ margin: "20px 0" }}>
          <button
            onClick={handleShowFavorites}
            style={{
              fontSize: "16px",
              marginRight: "10px",
              padding: "10px 20px",
              backgroundColor: "#f1c40f",
              color: "white",
              border: "none",
              borderRadius: "4px",
              cursor: "pointer",
            }}
          >
            Favoritos
          </button>
          <button
            onClick={handleShowAll}
            style={{
              fontSize: "16px",
              padding: "10px 20px",
              backgroundColor: "#3498db",
              color: "white",
              border: "none",
              borderRadius: "4px",
              cursor: "pointer",
            }}
          >
            Lista Completa
          </button>
        </div>

        <button
          onClick={() => {
            setSearchCity("");
            fetchAcomodacoes();
          }}
          style={{
            fontSize: "16px",
            margin: "10px 0",
            padding: "10px 20px",
          }}
        >
          Atualizar Lista Completa
        </button>

        <ul style={{ color: "black", listStyle: "none", padding: 0 }}>
          {filteredAcomodacoes.map((item) => (
            <li
              key={item.id}
              style={{
                backgroundColor: "white",
                padding: "15px",
                margin: "10px",
                borderRadius: "8px",
                boxShadow: "0 2px 4px rgba(0,0,0,0.1)",
                width: "400px",
                position: "relative",
              }}
            >
              <button
                onClick={() => handleToggleFavorite(item.id)}
                style={{
                  position: "absolute",
                  right: "10px",
                  top: "10px",
                  background: "none",
                  border: "none",
                  cursor: "pointer",
                  fontSize: "24px",
                  color: favorites.includes(item.id) ? "#ffd700" : "#ccc",
                }}
              >
                {favorites.includes(item.id) ? "★" : "☆"}
              </button>
              <strong style={{ fontSize: "18px" }}>{item.name}</strong>
              <p>
                {item.city}, {item.state}
              </p>
              <p style={{ color: "green", fontWeight: "bold" }}>
                R$ {item.priceNight},00/noite
              </p>
            </li>
          ))}
        </ul>
      </header>
    </div>
  );
}

export default App;
