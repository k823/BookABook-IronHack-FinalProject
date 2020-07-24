export class User {

    username: string;
    password: string;
    roles: Roles[];

    public getBasicAuth(): string {
        return 'Basic ' + btoa(this.username + ':' + this.password);
    }

    constructor(json: any) {
        this.username = json.username;
        this.password = json.password;
        this.roles = json.roles;
    }
}

class Roles {
    id: number;
    role: string;
}
