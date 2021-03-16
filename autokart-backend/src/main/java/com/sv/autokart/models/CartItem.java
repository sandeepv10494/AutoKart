package com.sv.autokart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    private Long quantity;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accesoryId", referencedColumnName = "accesoryId")
    private Accessory accessory;
}
