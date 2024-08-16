# Step 1 - 장바구니(상품 목록)

## 기능 요구 사항

1. 상품 목록 화면을 구현한다.

## 프로그래밍 요구 사항 
1. ViewModel, Hilt 등은 장바구니 미션에서 활용하지 않는다. 컴포즈 학습에 집중하자. 
2. 상품 목록 화면을 구현할 때 Lazy 컴포넌트를 활용한다. 
3. 컴포저블 함수가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
4. 의미있는 단위의 함수를 모아 별도의 파일로 분리해본다.

## 기능 목록
- [O] 상단 타이틀 구현
- [O] 상단 장바구니 아이콘 구현
- [O] 상품들을 격자 무늬 배치로 노출시킨다.

# Step 2 - 장바구(상세 상품)

## 기능 요구 사항
1. 상품 상세 화면을 구현한다.
   - 상품 목록에서 상품을 누르면 상품 상세 화면으로 이동한다. 
   - 뒤로 가기 버튼이나 아이콘을 누르면 직전 화면으로 돌아간다.
2. 장바구니 화면의 빈 껍데기를 연결한다. 
   - 상품 목록에서 장바구니 아이콘을 누르면 장바구니 화면으로 이동한다.
   - 상품 상세에서 장바구니 담기 버튼을 누르면 장바구니 화면으로 이동한다.
   - 뒤로 가기 버튼이나 아이콘을 누르면 직전 화면으로 돌아간다.
   - 장바구니에 실제로 상품이 담기는 기능은 이 단계에서 고려하지 않는다.

## 프로그래밍 요구 사항
1. 장바구니에 실제로 상품이 담기는 기능은 이 단계에서 고려하지 않는다.
2. 컴포저블 함수가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
   - 의미있는 단위의 함수를 모아 별도의 파일로 분리해본다.

## 기능 목록
- [] 상품 상세 화면 구현
  - [] 이미지 
  - [] 상품명
  - [O] 금액
  - [O] 상단 타이틀 바(상세 상품, 뒤로가기 버튼)
  - [] 하단 장바구니 담기 버튼
- [] 장바구니 화면 구현
  - [] 상닽 타이틀 바(상세 상품, 뒤로가기 버튼)