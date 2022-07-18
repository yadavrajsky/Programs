import { TestBed } from '@angular/core/testing';

import { LoginlogoutService } from './loginlogout.service';

describe('LoginlogoutService', () => {
  let service: LoginlogoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginlogoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
