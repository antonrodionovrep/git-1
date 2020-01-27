import {Component, OnInit} from "@angular/core";
import {Client} from "../../../../models/system-models/client.model";
import {ClientService} from "../../../../services/system-services/client.service";
import {AuthService} from "../../../../services/security-services/auth.service";

@Component({
  selector: 'clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls:['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {
  clients: Client[];

  constructor(private _clientService: ClientService, private _authService: AuthService) {}

  ngOnInit() {
    this._clientService.getClients()
      .subscribe(
        (clients: any[]) => {
          this.clients = clients
        },
        (error) => console.log(error)
      );
  }

  deleteClient(client){
    this._clientService.deleteClient(client.id).
    subscribe((data)=>{
      this.clients.splice(this.clients.indexOf(client),1);
    },(error)=>{
      console.log(error);
    });
  }
}
