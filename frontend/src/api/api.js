const BASE_URL = import.meta.env.VITE_API_URL;

const topicApiMap = {
  age: "ages",
  profitandloss: "profitAndLosses",
  simpleinterest: "simpleInterests",
  workandtime: "workAndTimes",
  speedtimedistance: "speedTimeDistances",
  mixtureandalligation: "mixtureandAlligations",
  pipesandcistern: "pipesandCisterns",
  permutationandcombination: "permutationAndCombinations",
  random: "randomQuestions",
};

export const getQuestionsByTopic = async (topic) => {
  // 🔑 normalize incoming topic
  const normalizedTopic = topic.toLowerCase().replace(/[\s&]/g, ""); // remove spaces & &

  const endpoint = topicApiMap[normalizedTopic];

  if (!endpoint) {
    console.error("❌ Unknown topic after normalize:", normalizedTopic);
    return [];
  }

  const url = `${BASE_URL}/api/${endpoint}`;
  console.log("✅ Fetching:", url);

  const res = await fetch(url);

  if (!res.ok) {
    throw new Error(`Failed to fetch ${endpoint}`);
  }

  return res.json();
};
