import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ClientService } from "../../../../services/system-services/client.service";
import { Service } from "../../../../models/system-models/service.model";

@Component({
  selector: 'app-client-service',
  templateUrl: './client-service.component.html',
  styleUrls: ['./client-service.component.css']
})
export class ClientServiceComponent implements OnInit {
  private service: Service;

  constructor(private activatedRoute: ActivatedRoute, private clientService: ClientService) {

  }

  ngOnInit(){
    this.activatedRoute.params.subscribe((param) =>{
      this.clientService.getClientService(param['id']).subscribe((service: Service) => {
        return this.service = service;
      });
    }, error => {
      console.log(error)
    });
  }

}
