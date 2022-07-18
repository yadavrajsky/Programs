import { KG_TO_G,greet,ob,DemoExport} from './../export';
import * as demoimport from './../export';
console.log(10*KG_TO_G);
greet();
console.log(ob.x);
console.log(demoimport.ob.x);
console.log(new DemoExport(20).x);