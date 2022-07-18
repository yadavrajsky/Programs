import { Component } from "@angular/core";

@Component({
    selector:'demo',
    template:`  <h1>Hello</h1>
                <h2>Angular</h2>`,
    styles:[`
    h1
    {
        color:red;
    }
    `,'h1{color:blue}h2{color:green}']
})
export class DemoComponent
{

}