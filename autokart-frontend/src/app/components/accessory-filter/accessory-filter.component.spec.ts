import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccessoryFilterComponent } from './accessory-filter.component';

describe('AccessoryFilterComponent', () => {
  let component: AccessoryFilterComponent;
  let fixture: ComponentFixture<AccessoryFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccessoryFilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccessoryFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
