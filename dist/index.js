"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.LocalizeTimeModule = exports.BrightnessModule = exports.SzNativeModule = exports.SzNativeEventEmitterModule = exports.SzNativeManager = exports.Counter = void 0;
//@ts-ignore
const react_native_1 = require("react-native");
// export const AdPie: HostComponent<AdPieComponentProps> = requireNativeComponent(
//   "SzAdPie",r
//   null
// );
// export const Counter = requireNativeComponent('Counter', null) as CounterComponentInterface;
exports.Counter = (0, react_native_1.requireNativeComponent)("Counter", null);
exports.SzNativeManager = (0, react_native_1.requireNativeComponent)("SzNativeManager", null);
exports.SzNativeEventEmitterModule = react_native_1.NativeModules.SzNativeEventEmitter;
exports.SzNativeModule = react_native_1.NativeModules.SzNative;
exports.BrightnessModule = react_native_1.NativeModules.BrightnessModule;
exports.LocalizeTimeModule = react_native_1.NativeModules.LocalizeTimeModule;
//# sourceMappingURL=index.js.map