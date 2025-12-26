import { useEffect, useRef } from "react";
import Typed from "typed.js";

export default function TypedEndpoints() {
  const textRef = useRef(null);

  useEffect(() => {
    const typed = new Typed(textRef.current, {
      strings: [
        "/ages",
        "/mixtureandAlligations",
        "/profitAndLoss",
        "/pipesandCistern",
        "/permutationandCombination",
        "/speedTimeDistance",
        "/simpleInterest",
        "/randomQuestions",
      ],
      typeSpeed: 80,
      backSpeed: 50,
      backDelay: 1500,
      loop: true,
    });

    return () => typed.destroy();
  }, []);

  return <span ref={textRef} />;
}
