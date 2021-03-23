import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccessorydetailsComponent } from './accessorydetails.component';

describe('AccessorydetailsComponent', () => {
  let component: AccessorydetailsComponent;
  let fixture: ComponentFixture<AccessorydetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccessorydetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccessorydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
