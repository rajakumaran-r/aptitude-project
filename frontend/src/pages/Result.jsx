import { useLocation, useNavigate } from "react-router-dom";

export default function Result() {
  const { state } = useLocation();
  const navigate = useNavigate();

  return (
    <div>
      <h1>Result</h1>
      <h2>
        Score: {state.score} / {state.total}
      </h2>
      <button onClick={() => navigate("/")}>Restart</button>
      <h3>Mode: {state.mode === "random" ? "Random Quiz 🎲" : state.mode}</h3>
    </div>
  );
}
