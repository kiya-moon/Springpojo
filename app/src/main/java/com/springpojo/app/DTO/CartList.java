package com.springpojo.app.DTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
@Entity
public class CartList {
	
	@Id
	@Column(name =" Cart_ID ")
	private int cartId; // 상품담긴 저장소 번호
	
	// 1 ~ 3 각 dto에서 떙겨올수있으면 그렇게하는걸추천 우선 한번에하기위해여기서홤
	@NotEmpty
	private long BidJoinNum; // 경매번호 1

	@NotEmpty
	private String userid; // 유저번호 2

	@NotEmpty
	private int procudtId; // 상품번호 3

	private int procudtCount; // 상품수량
	    
	//상품
	
	@NotEmpty
	private String procudtName; // 상품이름
	
	@NotEmpty
	private String procudtimage; // 상품이미지
	
	@NotEmpty// null / "" 차단
	private int procudtPrice; // 상품가격
	    
//	    private double bookDiscount; // 할인률(대기)
	    
	    // 추가
//	    private int salePrice; // 할인 (대기)
	    
//	    private int totalPrice; // 총할인(대기)
	    
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public void setuserId(String userId) {
			this.userid = userId;
		}

		public void setprocudtId(int procudtId) {
			this.procudtId = procudtId;
		}

		public void setprocudtCount(int procudtCount) {
			this.procudtCount = procudtCount;
		}

		public void setprocudtName(String procudtName) {
			this.procudtName = procudtName;
		}

		public void setprocudtPrice(int procudtPrice) {
			this.procudtPrice = procudtPrice;
		}

		@Override
		public String toString() {
			return "CartList [cartId=" + cartId + ", userId=" + userid + ", procudtId=" + procudtId + ", procudtCount="
					+ procudtCount + ", procudtName=" + procudtName + ", procudtPrice=" + procudtPrice + "]";
		}

}
