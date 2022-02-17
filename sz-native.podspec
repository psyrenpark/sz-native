# sz-native.podspec

require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "sz-native"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = "https://github.com/github_account/sz-native"
  # brief license entry:
  s.license      = "MIT"
  # optional - use expanded license entry instead:
  # s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = package["author"]
  # s.platforms    = { :ios => "10.0" }
  s.source       = { :git => "https://github.com/github_account/sz-native.git", :tag => "#{s.version}" }

  # https://github.com/lottie-react-native/lottie-react-native/blob/master/lottie-react-native.podspec

  s.ios.deployment_target = "10.0"
  s.swift_version = "5.5.1"
  s.osx.deployment_target = "10.10"
  s.tvos.deployment_target = "9.0"

  # s.source_files = "ios/**/*.{h,c,cc,cpp,m,mm,swift}"
  s.source_files  = "ios/**/*.{h,m,swift}"

  s.requires_arc = true
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES' }

  s.dependency "React-Core"
  s.dependency "AdPieSDK"
  # ...
  # s.dependency "..."
end

