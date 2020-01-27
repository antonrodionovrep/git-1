import {Authority} from "./Authority.model";
import {List} from "../../lib/list";

export class User{
  id: number;
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  email: string;
  enabled: boolean;
  lastPasswordReset: Date;
  authorities: List<Authority>;
}
