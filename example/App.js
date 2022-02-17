import React, { useEffect, useRef, useState } from 'react';
import {
  Button,
  Platform,
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  View,
  NativeEventEmitter,
  Alert,
  NativeModules,
  requireNativeComponent,
  UIManager,
  findNodeHandle,
  PixelRatio,
} from 'react-native';
import {
  SzNativeModule,
  SzNativeManager,
  SzNativeEventEmitterModule,
  BrightnessModule,
  LocalizeTimeModule,
  Counter,
  // AdPie,
} from '@psyrenpark/sz-native';
import dayjs, { Dayjs } from 'dayjs';

export const SzAdPie = requireNativeComponent('SzAdPie', null);
export const SzAdPie2 = requireNativeComponent('SzAdPie2', null);
export const SzAdPie3 = requireNativeComponent('SzAdPie3', null);
export const SzAdPie4 = requireNativeComponent('SzAdPie4', null);
export const SzAdPieModule = NativeModules.SzAdPie;

export const MyViewManager = requireNativeComponent('MyViewManager');

const createFragment = (viewId) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    UIManager.MyViewManager.Commands.create.toString(),
    [viewId]
  );

const App = () => {
  const [value, setValue] = useState(0);

  const [isOn, setIsOn] = useState(false);

  const [date, setDate] = useState('ttttt');

  const test1 = async (params) => {
    // if (Platform.OS === 'android') {
    // SzNativeModule.testToastShow('test');
    SzNativeModule.testToastShow('test');
    // }
  };

  const test2 = async (params) => {
    // if (Platform.OS === 'android') {
    SzNativeModule.testCallBack(
      't123',
      1123,
      (data) => {
        console.log('log -> -------------------------------------------');
        console.log('log -> ~ SzNativeModule.testCallBack ~ data', data);
        console.log('log -> -------------------------------------------');
        return '';
      },
      (error) => {
        console.log('log -> -------------------------------------------');
        console.log('log -> ~ SzNativeModule.testCallBack ~ error', error);
        console.log('log -> -------------------------------------------');
        return '';
      }
    );
    // }
  };

  const test3 = async (params) => {
    // if (Platform.OS === 'android') {
    const data = await SzNativeModule.testCallBackToAsync('t123', 1123);
    console.log('log -> -------------------------');
    console.log('log -> ~ App ~ data', data);
    console.log('log -> -------------------------');
    // }
  };

  const test4 = async (params) => {
    if (Platform.OS === 'android') {
      SzNativeModule.testStartActivity('123', 111);
    } else if (Platform.OS === 'ios') {
      // NativeModules.AppDelegate.pushVC('TestViewController');
    }
  };

  const test5 = async (params) => {
    if (Platform.OS === 'android') {
      SzNativeModule.testCreateEvent('12312312');
      // SzNativeEventEmitterModule.testEmitEvent('!2312');
    } else if (Platform.OS === 'ios') {
      // EventEmitter.testCreateEvent('123');
      // SzNativeModule.testCreateEvent('12312312');
      SzNativeEventEmitterModule.testEmitEvent('!2312');
    }
  };

  const test6 = async (params) => {
    // const data = await BrightnessModule.getConstants();
    const data = await NativeModules.BrightnessModule.getConstants();
    console.log('log -> ~ test6 ~ data', data);
    const data2 = await BrightnessModule.getBrightness();
    console.log('log -> ~ test6 ~ data2', data2);
  };

  const test7 = async (params) => {
    await BrightnessModule.setBrightness(0.2);
  };

  const test8 = async (params) => {
    await BrightnessModule.setBrightness(1);
  };

  const test9 = async (params) => {
    let nowTimestamp = parseInt(+dayjs());

    console.log('log -> ~ test9 ~ nowTimestamp', nowTimestamp);

    const data = await LocalizeTimeModule.getLocalizeTimeStringAsync(
      nowTimestamp,
      Platform.OS === 'android' ? 'yyMMMMdd' : 'yyMMMMdd'
    );

    // const data = LocalizeTimeModule.getLocalizeTimeString(
    //   nowTimestamp,
    //   'yyMMMMdd'
    // );

    setDate(data);

    console.log('log -> ~ test9 ~ data', data);

    // const data2 = LocalizeTimeModule.getConstants();
    // console.log('log -> ~ test9 ~ data', data2);
  };

  const onPressLeftButton = (params) => {
    setValue(value + 1);
  };

  const onPressRightButton = (event) => {
    console.log(
      'log -> ~ onPressRightButton ~ event',
      event.nativeEvent.message
    );
    setValue(value - 1);
  };

  useEffect(() => {
    const eventEmitter = new NativeEventEmitter(SzNativeEventEmitterModule);
    const eventListener = eventEmitter.addListener('EventReminder', (event) => {
      console.log('log -> ---------------------------------');
      console.log('log -> ~ useEffect ~ event', event);
      console.log('log -> ---------------------------------');
      Alert.alert('event', JSON.stringify(event, null, 3), [
        { text: 'ok', onPress: () => {} },
      ]);
    });
    return () => {
      eventListener.remove();
    };
  }, []);

  const ADPIE_STORE_KEY = '619b171265a17f6519f34fe5';
  const ADPIE_BANNER_KEY = '619b175065a17f6519f34fe7';
  const ADPIE_INTERSTITIAL_KEY = '619b173465a17f6467d5ddfe';

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView style={styles.scrollview}>
        <Text style={styles.welcome}>SzNative example☆</Text>
        <Button style={styles.button} title="testToastShow" onPress={test1} />
        <Button style={styles.button} title="testCallBack" onPress={test2} />
        <Button
          style={styles.button}
          title="testCallBackToAsync"
          onPress={test3}
        />
        <Button
          style={styles.button}
          title="testStartActivity"
          onPress={test4}
        />
        <Button style={styles.button} title="testCreateEvent" onPress={test5} />
        <Button style={styles.button} title="test" onPress={test6} />
        <Button style={styles.button} title="test7" onPress={test7} />
        <Button style={styles.button} title="test8" onPress={test8} />
        <Button
          style={styles.button}
          title="getLocalizeTimeString"
          onPress={test9}
        />
        <Text
          h4
          h4Style={{
            fontSize: 20,
            backgroundColor: 'red',
          }}
        >
          {date}
        </Text>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  scrollview: {
    width: '100%',
    flex: 1,
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  button: {
    width: '100%',
  },
});

// return (
//   <SafeAreaView
//     style={{
//       backgroundColor: 'blue',
//       flex: 1,
//       justifyContent: 'center',
//       alignItems: 'center',
//     }}
//   >
//     <View>
//       <SzAdPie4
//         style={{
//           // backgroundColor: 'red',
//           // flex: 1,
//           height: 600,
//           width: 320,
//         }}
//       />
//     </View>
//   </SafeAreaView>
// );

// return (
//   <SzAdPie2
//     style={{
//       flex: 1,
//       // backgroundColor: 'red',
//       // height: 600,
//       width: 320,
//       height: 480,
//     }}
//   />
// );
// const ref = useRef(null);

// useEffect(() => {
//   const viewId = findNodeHandle(ref.current);
//   createFragment(viewId);
// }, []);

// return (
//   <SafeAreaView
//     style={{
//       // backgroundColor: 'blue',
//       flex: 1,
//       justifyContent: 'center',
//       alignItems: 'center',
//     }}
//   >
//     <MyViewManager
//       style={{
//         // converts dpi to px, provide desired height
//         height: PixelRatio.getPixelSizeForLayoutSize(200),
//         // converts dpi to px, provide desired width
//         width: PixelRatio.getPixelSizeForLayoutSize(200),
//       }}
//       ref={ref}
//     />
//   </SafeAreaView>
// );

// useEffect(() => {
//   SzAdPieModule.init('test');

//   setTimeout(() => {
//     setIsOn(true);
//   }, 1000);
// }, []);

// return (
//   <SafeAreaView
//     style={{
//       // backgroundColor: 'blue',
//       flex: 1,
//       justifyContent: 'center',
//       alignItems: 'center',
//     }}
//   >
//     {isOn ? (
//       // <SzAdPie
//       //   style={{
//       //     flex: 1,
//       //     // backgroundColor: 'red',
//       //     // height: 300,
//       //     // width: 50,
//       //     width: '100%',
//       //     height: '100%',

//       //     // height: 500,
//       //   }}
//       // />
//       <SzAdPie3
//         style={{
//           height: 600,
//           width: 400,
//         }}
//       />
//     ) : (
//       // <SzAdPie2
//       //   style={{
//       //     flex: 1,
//       //     backgroundColor: 'red',
//       //   }}
//       // />
//       // <SzAdPie3
//       //   style={{
//       //     // flex: 1,
//       //     // backgroundColor: 'red',

//       //     height: 600,
//       //     width: 400,
//       //   }}
//       // />
//       // <View
//       //   style={{
//       //     backgroundColor: 'green',
//       //     height: 50,
//       //     // width: 50,
//       //     width: '100%',
//       //   }}
//       // ></View>
//       // <SzAdPie2
//       //   style={{
//       //     flex: 1,
//       //     backgroundColor: 'red',
//       //   }}
//       // />
//       <SzAdPie
//         style={{
//           flex: 1,
//           backgroundColor: 'red',
//         }}
//       />
//     )}

//     <Button
//       title="test"
//       onPress={() => {
//         setIsOn(!isOn);
//       }}
//     />
//     <Button
//       // style={styles.button}
//       title="testStartActivity"
//       onPress={test4}
//     />
//   </SafeAreaView>
// );

// return (
//   <SafeAreaView>
//     <View
//       style={{
//         height: 600,
//         width: '100%',
//       }}
//     >
//       <AdPie
//         style={{
//           flex: 1,
//           // **배너광고입니당
//           // width: 300,
//           // height: 250,
//           //**전면광고입니다 */
//           // width: 320,
//           // height: 480,
//           backgroundColor: 'blue',
//         }}
//         slotId={ADPIE_INTERSTITIAL_KEY}
//         onSuccess={() => {
//           console.log('rn-success');
//         }}
//         onFail={() => {
//           // console.log('success');
//           console.log('rn-fail');
//         }}
//         onClickAd={() => {
//           console.log('rn-click');
//         }}
//       />
//     </View>
//     <View
//       style={{
//         flex: 1,
//         backgroundColor: 'red',
//       }}
//     ></View>
//   </SafeAreaView>
// );
