<div align="center">

# 크리스마스 프로모션 미션 🎅🏻
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/><br>

</div>

## 👩🏻‍💻 구현할 기능 목록
1. 방문 날짜를 입력 받는다. (View) <br><br>
2. 주문할 메뉴와 개수를 입력 받는다. (View) <br>
   ✦ `형식`: `해산물파스타-2,레드와인-1,초코케이크-1`와 같이 메뉴는 `,`로 구분되고 메뉴와 개수는 `-`로 구분된다.<br><br>
3. 날짜와 주문 메뉴 목록을 출력한다. (View) <br>
   ✦ `형식`: `티본스테이크 1개`<br><br>
4. 주문으로부터 총주문 금액을 계산한다. (Service) <br>
   ✦ 총 주문 금액 10,000원 이상부터 이벤트가 적용된다.<br>
   ✦ 10,000원 미만이면 이하의 서비스 로직이 **필요하지 않다**. <br><br>
5. 할인 전 총주문 금액을 출력한다. (View) <br><br>
6. 총주문 금액을 확인하고 증정 이벤트를 결정한다. (Service) <br>
   ✦ 12만원이 넘는다면 샴페인 1개가 증정된다.<br><br>
7. 증정 메뉴를 출력한다. (View) <br><br>
8. 방문 날짜로 유효한 할인 이벤트를 구한다. (Service) <br>
   ✦ 중복된 할인과 증정을 허용한다.<br>
   ✦ 🎁 _**크리스마스 디데이 할인**_ : 1일부터 1,000원으로 시작하여 **25일까지** 100원씩 증가.<br>
   ✦ 🎁 _**평일 할인**_ (**일~목**): 디저트 메뉴 1개당 2,023원.<br>
   ✦ 🎁 _**주말 할인**_ (**금, 토**): 메인 메뉴 1개당 2,023원<br>
   ✦ 🎁 _**특별 할인**_ (**일, 크리스마스**): 1,000원<br><br>
9. 총 혜택 금액을 구한다. (Service) <br><br>
10. 총 혜택 내역을 출력한다. (View) <br>
   ✦ `주의` 혜택에는 할인 내역 뿐 아니라 증정 내역(샴페인 값 2500원)도 포함된다. <br>
   ✦ `형식`: `크리스마스 디데이 할인: -1,200원` <br><br>
11. 총 혜택 금액을 출력한다. (View) <br><br>
12. 할인 후 예상 결제 금액을 구한다. (Service) <br><br>
13. 할인 후 예상 결제 금액을 출력한다. (View) <br><br>
14. 총 혜택 금액을 통해 부여할 배지를 결정한다. (Service) <br>
    ✦ ⭐️ _**별**_ : 5,000원 이상<br>
    ✦ 🎄 _**트리**_ : 10,000원 이상<br>
    ✦ 🎅🏻 _**산타**_ : 20,000원 이상<br><br>
15. 이벤트 배지를 출력한다. (View) <br><br>

## 🚨 예외 처리
사용자가 잘못된 값을 입력할 경우 `Exception`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
1. **식당 예상 방문 날짜**<br>
   `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.`<br>
   ✦ 입력 값은 대응되는 자료형 `integer`으로 변환 가능해야 한다. <br>
   ✦ 1 이상 31 이하의 정수이다.<br>
   ✦ 양 옆 공백은 무시된다.<br><br>
2. **주문 메뉴와 개수**<br>
   `[ERROR] 음료만 주문할 수 없습니다.`<br>
   ✦ 음료만 주문 시 주문 불가하다.<br><br>
   `[ERROR] 메뉴는 한 번에 최대 20개까지 주문할 수 있습니다.`<br>
   ✦ 메뉴는 한 번에 최대 20개까지 주문 가능하다.<br><br>
   `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`<br>
   ✦ 메뉴판에 없는 메뉴는 주문할 수 없다.<br>
   ✦ 메뉴의 개수는 1 이상의 숫자이다.<br>
   ✦ 메뉴 형식이 예시대로 입력되어야 한다.<br>
   ➕ 추가로 고려한 예외들
   ```
   1️⃣ 해산물파스타-2, 레드와인-1 , 초코케이크-1      ➡️ ',' 사이 공백은 통과
   2️⃣ 해산물파스타 - 2, 레드와인 - 1, 초코케이크 - 1 ➡️ '-' 사이 공백은 통과
   3️⃣ 해산물파스타-2-2,레드와인-1,초코케이크-1       ➡️ 에러
   4️⃣ 해산물파스타 1개, 레드와인 2개               ➡️ 에러
   5️⃣ 해산물파스타-일, 레드와인-이                 ➡️ 에러
   ```
   ✦ 같은 메뉴를 여러 번 다시 입력할 수 없다.<br><br>

## 🏛️ 도메인 중심 프로젝트 구조
```
├── Application.java
├── config
│   └── AppConfig.java
├── view
│   ├── InputView.java
│   ├── OutputView.java
│   ├── request
│   │   ├── OrderRequest.java
│   │   └── VisitDateRequest.java
│   ├── response
│   │   ├── Response.java
│   │   └── ItemResponse.java
│   └── utility
│       ├── Reader.java
│       └── Writer.java
├── controller
│   └── PromotionController.java
├── domain
│   ├── VisitDate.java
│   ├── Day.java
│   ├── Menu.java
│   ├── MenuType.java
│   ├── Order.java
│   ├── Discount.java
│   ├── Benefit.java
│   └── Badge.java
└── constants
    └── ErrorMessage.java

```
### ✦ Domain <br>
`VisitDate` <br>
할인 이벤트의 중요한 기준 중 하나는 날짜이다. 크리스마스(25일)와의 비교, 요일을 반환하는 메서드가 있다.<br><br>
`Day` <br>
요일과 `offset`을 저장하는 `enum`이다. `offset`은 날짜를 7로 나눈 나머지로 달별로 바뀌는 값이다. `offset`만 바꿔주면 추후 1월 이벤트에서도 활용할 수 있다.<br><br>
`Menu` <br>
메뉴의 타입, 이름, 가격을 저장하는 `enum`이다. <br><br>
`MenuType` <br>
애피타이저, 메인 메뉴 등 타입을 저장한다. 중복되는 사용이 있고 타입에 따라 적용되는 할인이 있기에 enum 클래스를 따로 생성하였다.<br><br>
`Order` <br>
_key_ 가 `Menu`이고 _value_ 가 주문 수인 `Map`을 필드로 갖는 `일급 컬렉션`이다. 총 주문 금액을 구하는 메서드가 있다.<br><br>
`Discount` <br>
할인 이벤트들을 저장한다. 할인 금액, 이름, 대상 메뉴를 필드로 갖는 `enum`이다. 
각 할인에 대해 다른 할인 적용 방식(=할인 금액 계산)은 내부 메서드로 정의한다.<br><br>
`Benefit` <br>
혜택 내역을 저장한다. 방문날짜와 주문으로 혜택을 산정하고 저장한다. 할인 종목과 그 적용 금액을 저장하는 `Map`과 증정품 메뉴와 그 개수를 저장하는 `Map`을 필드로 갖는다.
지불 금액, 혜택 금액, 할인 금액을 계산하는 메서드가 있다.<br><br>
`Badge` <br>
총 혜택 금액을 통해 부여되는 배지를 관리하는 `enum`이다. 이름과 기준 금액을 필드로 갖는다.<br><br>

### ✦ 요청과 응답을 담당하는 불변 객체 <br>
입•출력 형식에 대한, 도메인에 관심사에 적절하지 않은 유효성 검사나 변환을 담당한다. 입출력 형식에 구애 받지 않고 도메인 클래스들을 다룰 수 있다.<br>
- 참고) 저번 미션들에서는 `DTO`나 `Value Object`라는 표현을 사용했지만, 지켜지지 않는 특성들이 존재했다. `DTO`라기엔 `getter`와 `setter`외의 로직이 존재했고, 
`Value Object`라기엔 다른 사용 목적을 가졌고 `hashCode()`나 `equals()`를 재정의할 필요가 없다. 따라서 해당 용어들을 사용하지 않았다.
<br><br>

### ✦ 나머지 역할의 구조들 <br>
`PromotionController` <br>
프로그램을 제어한다.<br><br>
`InputView` <br>
입력을 담당한다.<br><br>
`OutputView` <br>
출력을 담당한다.<br><br>

## 📩 커밋 메세지
아래와 같은 형식을 지킨다.
```
유형(범위): 제목

- WHY: 사용한 이유
- ISSUE: 고민한 부분
```
1. **유형**: 커밋의 유형이다. <br><br>
2. **범위**: 변경된 부분이다. 주로 메서드명과 클래스명이다.<br><br>
3. **제목**: 커밋 사항의 핵심 내용이다.<br><br>
4. **내용**:
    1. **WHY**: 해당 구현 방식을 사용한 이유이다.
    2. **ISSUE**: 추가적으로 고민한 부분이다.<br><br>

## 📑 집중한 사항들
**1. 기능 목록과 예외 사항을 상세히 작성한다** <br>
✦ 프로그램의 흐름을 직관적으로 이해하기 위해서 기능 목록의 기재 순서는 실제 프로그램에서 로직의 진행 순서로 작성한다.<br>
✦ 명시되지 않은 예외 사항도 처리한다.<br><br>
**2. 객체지향을 지키기 위해 노력한다.** <br>
✦ view에서 사용할 데이터가 아니라면 `getter`를 지양한다. <br>
✦ 객체의 상태를 반환하기 위해서 `toString()`을 적극 활용한다.
```java
public enum Badge {
   TREE("트리", 10_000),
   SANTA("산타", 20_000);
    // .. 생략
    @Override
    public String toString() {
      return name;
   }
}
```
✦ `enum`을 적극 활용한다.<br>
할인 도메인을 `enum`으로 구현하였다. 적용 메뉴와 할인될 금액을 저장하고 내부 인스턴스 메서드로 할인 금액을 계산한다. 적절한 인스턴스에서 메서드가 불렸는지 꼭 검증한다. 
```java
public enum Discount {
    CHRISTMAS(100, MenuType.ENTIRE, "크리스마스 디데이 할인"),
    // .. 생략
    SPECIAL(1_000, MenuType.ENTIRE, "특별 할인");
    
    public Map<Discount, Integer> calculateChristmasDiscount(final VisitDate date) {
      validate(CHRISTMAS);
      int offset = 1_000;
      return Map.of(this, date.getChristmasDiscountWeight() * amount + offset);
    }
    
    private void validate(Discount...discounts) {
      if (Arrays.stream(discounts).noneMatch(this::equals)) {
         throw new IllegalStateException(INVALID_DISCOUNT_INSTANCE);
      }
    }
}
```
**3. 코드의 재사용성을 높인다.**<br>
✦ 하드코딩하지 않는다. 이벤트는 1월에도 실행될 예정이기에 날짜에서 요일을 구하는 로직은 쉽게 재사용되어야 한다.<br>
```java
// 요일 클래스 내부에 있는 요일을 구하는 메서드
public static Day findByDate(final int date) {
    final int offset = date % 7;
    return Arrays.stream(Day.values())
        .filter(day -> day.offset == offset) // 추후 offset만 변경하면 된다
        .findAny().get();
    }
```
✦ 혜택 이벤트가 바뀌어 재사용될 수 있으므로, 범용성이 있는 자료구조를 사용한다.
현재는 중정품이 샴페인 1개로 고정되어 있지만 `boolean`으로 증정품 여부를 저장하는 것은 효율적이지 않다고 판단했다.
```java
public class Benefit {
   private final Map<Menu, Integer> giftCounts;
}
```
**4. 꼭 필요하지 않으면 쓰지 않는다.**<br>
✦ 써야 하는 이유를 딱 잘라 말할 수 없다면 쓰지 않는다.<br>
✦ 계산 결과를 저장할 때 null 값을 암시할 필요가 없다면 원시타입(`int`)을 사용한다.<br>
✦ 단순 한 쌍의 `key`와 `value`를 반환해야 한다면, 가독성이 좋은 `Map`을 사용하였다.
```java
public Map<Discount, Integer> calculateSpecialDiscount() {
    validate(SPECIAL);
    return Map.of(this, amount);
}
```
**5. 도메인 간 책임을 분명히 한다.**<br>
✦ `Discount`(할인)에서는 할인 금액을 계산하고 `Benefit`(혜택)에서는 기준에 따라 할인 금액 메서드를 호출한 뒤 할인 내역을 저장했다.<br>
**5. 중복되는 코드를 줄인다.**<br>
✦ 비슷한 역할을 하지만, 클래스를 합칠 수 없다면 상속을 활용했다.<br>
```java
public class Response {
   protected List<String> convertMapToMessage(final Map<?, Integer> map, final String FORMAT) {
       // .. 생략
   }
   protected List<String> checkEmptyList(final List<String> message) {
      // .. 생략
   }
}

public class BenefitResponse extends Response {
    // .. 생략
   private List<String> convertToMessage(
           final Map<Discount, Integer> discountAmounts, final int giftAmounts) {
      List<String> message = convertMapToMessage(discountAmounts, FORMAT);

      if(giftAmounts != 0) {
         String gift = String.format(FORMAT, GIFT_MESSAGE, giftAmounts);
         message.add(gift);
      }

      return checkEmptyList(message);
   }
}

public class ItemResponse extends Response {
   private List<String> convertToMessage(final Map<Menu, Integer> items) {
      List<String> message = convertMapToMessage(items, FORMAT);
      return checkEmptyList(message);
   }
}
```