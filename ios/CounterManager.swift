//
//  CounterManager.swift
//  sz-native
//
//  Created by 경복박 on 2021/12/27.
//

@objc (CounterManager)
class CounterManager : RCTViewManager {
    
    
    override static func requiresMainQueueSetup() -> Bool {
        return true
    }
    
    override func view() -> UIView! {
        return CounterView()
    }
    

}
