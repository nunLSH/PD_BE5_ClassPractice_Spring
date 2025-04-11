const options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0,
};

const api = () => {

  return new Promise((resolve, reject) => {
    navigator.geolocation.getCurrentPosition(pos => {
      const crd = pos.coords;
      resolve({latitude: crd.latitude, longitude: crd.longitude});
    }, err => {
      reject(err);
    }, options);
  });
}

export default api;

function success(pos) {
  const crd = pos.coords;
  console.log("Your current position is:");
  console.log(`Latitude : ${crd.latitude}`);
  console.log(`Longitude: ${crd.longitude}`);
  console.log(`More or less ${crd.accuracy} meters.`);
}

function error(err) {
  console.warn(`ERROR(${err.code}): ${err.message}`);
}