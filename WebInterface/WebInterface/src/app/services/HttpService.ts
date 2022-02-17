import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyLocationDto} from "../models/CompanyLocationDto";
import {Location} from "../models/Location";


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {

  }

  getAllData(): Observable<CompanyLocationDto[]> {
    return this.http.get<CompanyLocationDto[]>('http://localhost:8080/getAllCompanyWithLocations');
  }

  saveData(location: Location, companyId: number): void {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    let objectObservable = this.http.post(`http://localhost:8080/addLocation/` + companyId, location, {headers: headers});
    objectObservable.subscribe(data => {
      console.log(data);
    });
  }
}
