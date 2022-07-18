import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirebasedemoComponent } from './firebasedemo.component';

describe('FirebasedemoComponent', () => {
  let component: FirebasedemoComponent;
  let fixture: ComponentFixture<FirebasedemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FirebasedemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FirebasedemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
