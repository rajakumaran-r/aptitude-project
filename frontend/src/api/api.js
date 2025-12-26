import axios from "axios";

const BASE_URL = "http://localhost:8080";

const topicApiMap = {
  Age: "/ages",
  ProfitAndLoss: "/profitAndLosses",
  SimpleInterest: "/simpleInterests",
  WorkAndTime: "/workAndTimes",
  SpeedTimeDistance: "/speedTimeDistances",
  MixtureandAlligation: "/mixtureandAlligations",
  PipesandCistern: "/pipesandCisterns",
  PermutationandCombination: "/permutationAndCombinations",
  Random: "/randomQuestions",
};

export const getQuestionsByTopic = async (topic) => {
  let apiTopic = topic.toLowerCase();

  // 🔧 FIX ONLY THESE TWO (DO NOT TOUCH OTHERS)
  if (apiTopic === "age") {
    apiTopic = "ages";
  }

  if (apiTopic === "pipesandcistern") {
    apiTopic = "pipesandcisterns";
  }

  const res = await fetch(`${BASE_URL}/api/${apiTopic}`);

  if (!res.ok) {
    throw new Error(`Failed to fetch ${apiTopic}`);
  }

  return res.json();
};
