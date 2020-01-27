import {City} from "./city.model";
import {Street} from "./street.model";

export class House{
  id:Number;
  city:City;
  street:Street;
  houseNumber:string;
  constructor(city:City,street:Street,houseNumber:string){
    this.city = city;
    this.street = street;
    this.houseNumber=houseNumber;
  }
}
