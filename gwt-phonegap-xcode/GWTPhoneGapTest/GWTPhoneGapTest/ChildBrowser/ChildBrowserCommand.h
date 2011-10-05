//
//  PhoneGap ! ChildBrowserCommand
//
//
//  Created by Jesse MacFadyen on 10-05-29.
//  Copyright 2010 Nitobi. All rights reserved.
//

#import <Foundation/Foundation.h>
#ifdef PHONEGAP_FRAMEWORK
#import <PhoneGap/PGPlugin.h>
#import <PhoneGap/NSData+Base64.h>
#import <PhoneGap/JSON.h> 
#else
#import "PGPlugin.h"
#import "NSData+Base64.h"
#import "JSON.h" 
#endif
#import "ChildBrowserViewController.h"



@interface ChildBrowserCommand : PGPlugin <ChildBrowserDelegate>  {

	ChildBrowserViewController* childBrowser;
}

@property (nonatomic, retain) ChildBrowserViewController *childBrowser;


- (void) showWebPage:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) onChildLocationChange:(NSString*)newLoc;

@end
