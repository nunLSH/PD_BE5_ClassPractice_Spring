const API_KEY = 'eda4d8b1f364d02dd8a996c63701c5cc';
const API_URL = 'https://api.openweathermap.org/data/2.5/weather?'

const api = async coords => {
  const params = {
    appid: API_KEY,
    lat: coords.latitude,
    lon: coords.longtitude,
    units: 'metric'
  };

  const url =  API_URL + new URLSearchParams(params).toString();
  const response = await fetch(url);
  return response.json();
}

export default api;