import Foundation
import UIKit

@objc(LocalizeTimeModule)
class LocalizeTimeModule : NSObject {
    
    
    // @objc
    // func constantsToExport() -> [AnyHashable : Any]! {
    //     return [
    //         "STRING_VALUE" : "Hello World",
    //         "NUMBER_VALUE" : 15
    //     ]
    // }
    
    
    // @objc
    // func getBrightness(_ resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock){
    //     resolve(UIScreen.main.brightness)
    // }
    
    // @objc
    // func setBrightness(_ brightness : CGFloat){
    //     print("Setting brightness to \(brightness)")
    //     DispatchQueue.main.async {
    //         UIScreen.main.brightness = brightness
    //     }
        
    // }

    @objc
    func getLocalizeTimeStringAsync(_ _timestamp: NSNumber, _format: String, resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock){
        
        var date = NSDate() // 현재 시간 가져오기
        
        if(_timestamp != 0) {
            
            let epocTime = TimeInterval(truncating: NSNumber(value: _timestamp as! Int / 1000));
            print(epocTime);
            
            date = NSDate(timeIntervalSince1970: epocTime)
        }
        
        let formatter = DateFormatter()
        
       
        // let localeID = Locale.preferredLanguages.first
        // let locale = (Locale(identifier: localeID!).languageCode)!
        // formatter.locale = Locale(identifier: locale) // 로케일 변경

        let locale = NSLocale.current.languageCode;
        formatter.locale = Locale(identifier: locale!) // 로케일 변경
        formatter.setLocalizedDateFormatFromTemplate("dd MMMM")
        
        if(_format != "") {
            formatter.setLocalizedDateFormatFromTemplate(_format)
        }
        
        resolve(formatter.string(from: date as Date))
    }


    @objc
    func getLocalizeTimeStringAsyncV2(_ _timestamp: NSNumber, _format: String, resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock){
        
        var date = NSDate() // 현재 시간 가져오기
        
        if(_timestamp != 0) {
            
            let epocTime = TimeInterval(truncating: NSNumber(value: _timestamp as! Int / 1000));
            print(epocTime);
            
            date = NSDate(timeIntervalSince1970: epocTime)
        }
        
        let formatter = DateFormatter()
        
        let localeID = Locale.preferredLanguages.first
        let locale = (Locale(identifier: localeID!).languageCode)!

        // let locale = NSLocale.current.languageCode;
        formatter.locale = Locale(identifier: locale) // 로케일 변경
        formatter.setLocalizedDateFormatFromTemplate("dd MMMM")
        
        if(_format != "") {
            formatter.setLocalizedDateFormatFromTemplate(_format)
        }
        
        resolve(formatter.string(from: date as Date))
    }

    
    @objc
    static func requiresMainQueueSetup() -> Bool {
        return true
    }
    
}
