"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.SzNativeModule = exports.SzNativeEventEmitterModule = exports.SzNativeManager = void 0;
//@ts-ignore
const react_native_1 = require("react-native");
exports.SzNativeManager = react_native_1.requireNativeComponent("SzNativeManager", null);
exports.SzNativeEventEmitterModule = react_native_1.NativeModules.SzNativeEventEmitter;
exports.SzNativeModule = react_native_1.NativeModules.SzNative;
//# sourceMappingURL=index.js.map