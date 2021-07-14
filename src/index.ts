//@ts-ignore
import { NativeModules, requireNativeComponent } from "react-native";

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

export const SzNativeManager = requireNativeComponent("SzNativeManager", null);
export const SzNativeEventEmitterModule =
  NativeModules.SzNativeEventEmitter as SzNativeEventEmitterModuleInterface;
export const SzNativeModule = NativeModules.SzNative as SzNativeModuleInterface;
