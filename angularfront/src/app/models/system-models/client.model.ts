import {Address} from "./address.model";
import {Service} from "./service.model";
import {BillingAccount} from "./billingAccount.model";

export class Client{
  id:string;
  surname:string;
  name:string;
  patronymic:string;
  phoneNumber:string;
  address:Address;
  service:Service;
  billingAccount: BillingAccount;

  // constructor(surname:string, name:string, patronymic:string,
  //             phoneNumber:string, address:Address,
  //             wayOfPayment:WayOfPayment, service:Service){
  //   this.surname = surname;
  //   this.name = name;
  //   this.patronymic = patronymic;
  //   this.phoneNumber = phoneNumber;
  //   this.address = address;
  //   this.wayOfPayment = wayOfPayment;
  //   this.service = service;
  // }
}
