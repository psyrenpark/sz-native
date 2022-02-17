//@ts-ignore
import React, { ReactElement } from "react";
//@ts-ignore
import {
  NativeModules,
  requireNativeComponent,
  ViewProps,
  ViewStyle,
  HostComponent,
  //@ts-ignore
} from "react-native";

type CallbackType = (data: string) => Promise<void>;
interface SzNativeModuleInterface {
  testToastShow(name: string): void;
  testCallBack(
    stringArgument: string,
    numberArgument: number,
    successCallback: CallbackType,
    failureCallback: CallbackType
  ): void;

  testCallBackToAsync(
    stringArgument: string,
    numberArgument: number
  ): Promise<String>;

  testStartActivity(name: string, age: number): void;
  testCreateEvent(text: string): void;
}

interface SzNativeEventEmitterModuleInterface {
  testEmitEvent(message: string): void;
}
interface BrightnessModuleInterface {
  getConstants(): any;

  getBrightness(): Promise<any>;

  setBrightness(brightness: number): Promise<String>;
}

interface LocalizeTimeModuleInterface {
  getConstants(): any;
  getLocalizeTimeStringAsync(_date: number, format: string): Promise<any>;
  // getLocalizeTimeString(): string;
}

interface CounterComponentInterface {
  value?: number;
  leftButtonText?: string;
  rightButtonText?: string;
  onPressLeftButton?: Function;
  onPressRightButton?: Function;
}

interface AdPieComponentProps {
  slotId: string;
  onSuccess: Function;
  onFail: Function;
  onClickAd: Function;
  style: ViewStyle;
}

// export const AdPie: HostComponent<AdPieComponentProps> = requireNativeComponent(
//   "SzAdPie",r
//   null
// );

// export const Counter = requireNativeComponent('Counter', null) as CounterComponentInterface;
export const Counter = requireNativeComponent("Counter", null);
export const SzNativeManager = requireNativeComponent("SzNativeManager", null);

export const SzNativeEventEmitterModule =
  NativeModules.SzNativeEventEmitter as SzNativeEventEmitterModuleInterface;
export const SzNativeModule = NativeModules.SzNative as SzNativeModuleInterface;
export const BrightnessModule =
  NativeModules.BrightnessModule as BrightnessModuleInterface;

export const LocalizeTimeModule =
  NativeModules.LocalizeTimeModule as LocalizeTimeModuleInterface;
