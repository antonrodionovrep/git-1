import {Headers, Http, RequestOptions, Response} from "@angular/http";
import "rxjs/Rx";
import {Client} from "../../models/system-models/client.model";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {AuthService} from "../security-services/auth.service";

@Injectable()
export class ClientService {
  private headers = new Headers({'Content-Type':'application/json', 'Authorization': 'Bearer ' + this.authenticationService.getToken()});
  private options = new RequestOptions({headers:this.headers});
  constructor(private _http: Http, private authenticationService: AuthService) {}

  getClients(){
    return this._http.get('http://localhost:8080/api/clients', this.options)
      .map(
        (response: Response) => {
          return response.json();
        }
      ).catch(this.errorHandler);
  }

  getClientById(id:string){
    return this._http.get('http://localhost:8080/api/clients/' + id, this.options)
      .map(
        (response: Response) => {
          return response.json();
        }
      ).catch(this.errorHandler);
  }

  deleteClient(id: string){
    return this._http.delete('http://localhost:8080/api/client/'+ id, this.options).map(
      (response: Response) => {
        return response.json();
      }
    ).catch(this.errorHandler);
  }

  getClientBillingAccount(id: string){
    return this._http.get('http://localhost:8080:/api/clients/' + id + '/billingAcc', this.options).map(
      (response: Response) => {
        return response.json();
      }
    ).catch(this.errorHandler);
  }

  getClientService(id: string){
    return this._http.get('http://localhost:8080:/api/clients/' + id + '/service', this.options).map(
      (response: Response) => {
        return response.json();
      }
    ).catch(this.errorHandler)
  }

  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
}
