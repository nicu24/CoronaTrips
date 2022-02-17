import { Component } from '@angular/core';
import {HttpService} from "./services/HttpService";
import {CompanyLocationDto} from "./models/CompanyLocationDto";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  companyLocations: CompanyLocationDto[] = [];
  selectedId: number | undefined;
  title = 'WebInterface';

  constructor(private rest:HttpService) { }

  ngOnInit(): void {
    this.rest.getAllData().subscribe(data=>{
      this.companyLocations = data;
  });
  }

  selected(selectedId:any) {
    console.log(selectedId+"Selected")
    this.selectedId = selectedId;
  }
}
