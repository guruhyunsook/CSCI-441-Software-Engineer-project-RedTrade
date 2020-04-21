import axios from "axios";

const api = axios.create({
  baseURL: "https://cloud.iexapis.com/stable",
  token: "pk_36e8ca73ae824ab5958e04217dc6d060"
});

export const loadQuotesForStock = symbol => {
  return api.get(`/stock/${symbol}/quote?token=pk_36e8ca73ae824ab5958e04217dc6d060`).then(res => res.data);
};

export const loadLogoForStock = symbol => {
  return api.get(`/stock/${symbol}/logo?token=pk_36e8ca73ae824ab5958e04217dc6d060`).then(res => res.data.url);
};

export const loadRecentNewsForStock = symbol => {
  return api.get(`/stock/${symbol}/news?token=pk_36e8ca73ae824ab5958e04217dc6d060`).then(res => res.data);
};

export const loadChartForStock = (symbol, range) => {
  return api.get(`/stock/${symbol}/chart/${range}?token=pk_36e8ca73ae824ab5958e04217dc6d060`).then(res => res.data);
};