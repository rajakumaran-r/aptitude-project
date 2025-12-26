import { Routes, Route } from "react-router-dom";
import Landing from "./pages/Landing";
import Topics from "./pages/Topics";
import Quiz from "./pages/Quiz";
import Result from "./pages/Result";
import Questions from "./pages/Questions";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Landing />} />
      <Route path="/topics" element={<Topics />} />
      <Route path="/questions" element={<Questions />} />
      <Route path="/quiz" element={<Quiz />} />
      <Route path="/result" element={<Result />} />
    </Routes>
  );
}
