package com.ats.tril.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentDamageDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "damage_qty")
	private float damageQty;
	
	@Column(name = "damage_value")
	private float damagValue;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public float getDamagValue() {
		return damagValue;
	}

	public void setDamagValue(float damagValue) {
		this.damagValue = damagValue;
	}

	@Override
	public String toString() {
		return "CurrentDamageDetail [itemId=" + itemId + ", damageQty=" + damageQty + ", damagValue=" + damagValue
				+ "]";
	}
	
	

}
