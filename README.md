# sz-rn-module

## 설명

이 모듈은 superzer v2 개발에서 사용됩니다.
szv2-rn-app에서 기존 superzer v1의 native 소스 및 기능을 사용되기 위해 만들어 졌습니다.

## react native 세팅

- https://reactnative.dev/docs/environment-setup 의 React Native CLI Quickstart 쪽 참고
- react native 환경 구축하기

```properties
brew install node
brew install watchman

npm install -g yarn
등등등
```

## 준비하기

- 프로젝트 설정

```properties
git clone [깃주소]

// react native
cd example
yarn
yarn start

// ios
cd example
cd ios && pod install
yarn ios

// android
cd example
yarn android
```

## 시작하기

- **[중요]** 터미널 또는 vscode에서 cd [경로]/example && yarn start
- xcode 에서 open할 폴더 경로를 [경로]/example/ios 로 열고 빌드
- android studio 에서 open할 폴더 경로를 [경로]/example/android로 열고 빌드

## native migration 작업후 type 지적 필요

- [경로]/src/index.ts 에서 추가된 내용 정의 필요
- [경로] yarn run build
- [경로] yarn run clean
