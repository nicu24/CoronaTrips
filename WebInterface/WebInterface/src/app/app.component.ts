import { Component } from '@angular/core';
import {HttpService} from "./services/HttpService";
import {CompanyLocationDto} from "./models/CompanyLocationDto";
import {Location} from "./models/Location";
import {core} from "@angular/compiler";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  companyLocations: CompanyLocationDto[] = [];
  selectedId: number | undefined;
  title = 'WebInterface';
  isVisible = false;
  location: Location = new Location();

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

  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    console.log(this.location.locationName);
    console.log(this.selectedId);
    if(this.selectedId!= undefined){
      let loc:Location = new Location();
      loc.locationId = this.companyLocations[this.selectedId].locations.length+1;
      loc.locationName = this.location.locationName;
      this.rest.saveData(this.location,this.selectedId);
      this.companyLocations[this.selectedId-1].locations = [...this.companyLocations[this.selectedId].locations,loc];
      this.companyLocations.forEach(data=>{
        data.locations = [...data.locations];
        console.log(data.locations.length);
      });
    }
    this.isVisible = false;

  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.isVisible = false;
  }
}
