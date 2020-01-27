import {Component, Input, OnInit} from '@angular/core';
import {Client} from "../../../../models/system-models/client.model";
import {ClientService} from "../../../../services/system-services/client.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit {
  private client: Client;

  constructor(private activatedRoute: ActivatedRoute, private clientService: ClientService) {

  }


  ngOnInit(){
    this.activatedRoute.params.subscribe((param) =>{
      this.clientService.getClientById(param['id']).subscribe((client: Client) => {
        return this.client = client;
      });
    }, error => {
      console.log(error)
    });
  }

}

