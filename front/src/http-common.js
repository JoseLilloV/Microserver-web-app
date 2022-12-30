import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
    "Access-Control-Allow-Headers": "*",
    'Access-Control-Allow-Credentials': 'true',
  }
});