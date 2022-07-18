import { AbstractControl, ValidationErrors } from "@angular/forms";

export class SpaceValidator
{
   static isSpace(control:AbstractControl):ValidationErrors|null
    {
        if((control.value as string).indexOf(" ")>=0 )
        {
            return { 'isspace':true};
        }
        else
        {
            return null;

        }
    }

}