import React, {useEffect} from 'react';
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
} from 'react-native';
import {
  SzNativeModule,
  SzNativeManager,
  SzNativeEventEmitterModule,
} from 'sz-native';

const App = () => {
  const test1 = async params => {
    // if (Platform.OS === 'android') {
    // SzNativeModule.testToastShow('test');
    SzNativeModule.testToastShow('test');
    // }
  };

  const test2 = async params => {
    // if (Platform.OS === 'android') {
    SzNativeModule.testCallBack(
      't123',
      1123,
      data => {
        console.log('log -> -------------------------------------------');
        console.log('log -> ~ SzNativeModule.testCallBack ~ data', data);
        console.log('log -> -------------------------------------------');
        return '';
      },
      error => {
        console.log('log -> -------------------------------------------');
        console.log('log -> ~ SzNativeModule.testCallBack ~ error', error);
        console.log('log -> -------------------------------------------');
        return '';
      },
    );
    // }
  };

  const test3 = async params => {
    // if (Platform.OS === 'android') {
    const data = await SzNativeModule.testCallBackToAsync('t123', 1123);
    console.log('log -> -------------------------');
    console.log('log -> ~ App ~ data', data);
    console.log('log -> -------------------------');
    // }
  };

  const test4 = async params => {
    if (Platform.OS === 'android') {
      SzNativeModule.testStartActivity('123', 111);
    } else if (Platform.OS === 'ios') {
      // NativeModules.AppDelegate.pushVC('TestViewController');
    }
  };

  const test5 = async params => {
    if (Platform.OS === 'android') {
      SzNativeModule.testCreateEvent('12312312');
      // SzNativeEventEmitterModule.testEmitEvent('!2312');
    } else if (Platform.OS === 'ios') {
      // EventEmitter.testCreateEvent('123');
    }
  };

  // useEffect(() => {
  //   const eventEmitter = new NativeEventEmitter(SzNativeEventEmitterModule);
  //   const eventListener = eventEmitter.addListener('EventReminder', event => {
  //     console.log('log -> ---------------------------------');
  //     console.log('log -> ~ useEffect ~ event', event);
  //     console.log('log -> ---------------------------------');
  //     Alert.alert('event', JSON.stringify(event, null, 3), [
  //       {text: 'ok', onPress: () => {}},
  //     ]);
  //   });
  //   return () => {
  //     eventListener.remove();
  //   };
  // }, []);

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
