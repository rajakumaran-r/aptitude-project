import { Link, useLocation } from "react-router-dom";

export default function Navbar({ score, total }) {
  const location = useLocation();

  return (
    <nav className="navbar">
      <h2 className="logo">AptitudeApp</h2>

      <div className="nav-links">
        <Link to="/" className={location.pathname === "/" ? "active" : ""}>
          Home
        </Link>

        <Link
          to="/topics"
          className={location.pathname === "/topics" ? "active" : ""}
        >
          Topics
        </Link>

        {total !== undefined && (
          <span className="score">
            Score: {score}/{total}
          </span>
        )}
      </div>
    </nav>
  );
}
