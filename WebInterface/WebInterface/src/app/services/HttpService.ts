import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyLocationDto} from "../models/CompanyLocationDto";




@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {

  }

  getAllData(): Observable<CompanyLocationDto[]> {
    return this.http.get<CompanyLocationDto[]>('http://localhost:8080/getAllCompanyWithLocations');
  }

  // saveData(product:Product): void{
  //   let headers = new HttpHeaders();
  //   headers = headers.set('Content-Type', 'application/json; charset=utf-8');
  //   let objectObservable = this.http.post(`http://localhost:8080/data/save`, product, {headers: headers});
  //   objectObservable.subscribe();
  // }
}
