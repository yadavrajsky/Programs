import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvventComponent } from './evvent.component';

describe('EvventComponent', () => {
  let component: EvventComponent;
  let fixture: ComponentFixture<EvventComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EvventComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EvventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
