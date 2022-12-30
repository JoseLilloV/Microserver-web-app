import http from "../http-common.js";

class HoraExtraDataService{
    createHoraExtra(registro){
        return http.post("HoraExtra/", registro)
    }   
}

export default new HoraExtraDataService();