declare type CallbackType = (data: string) => Promise<void>;
interface SzNativeModuleInterface {
    testToastShow(name: string): void;
    testCallBack(stringArgument: string, numberArgument: number, successCallback: CallbackType, failureCallback: CallbackType): void;
    testCallBackToAsync(stringArgument: string, numberArgument: number): Promise<String>;
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
    getLocalizeTimeStringAsync(): Promise<any>;
}
export declare const Counter: any;
export declare const SzNativeManager: any;
export declare const SzNativeEventEmitterModule: SzNativeEventEmitterModuleInterface;
export declare const SzNativeModule: SzNativeModuleInterface;
export declare const BrightnessModule: BrightnessModuleInterface;
export declare const LocalizeTimeModule: LocalizeTimeModuleInterface;
export {};
