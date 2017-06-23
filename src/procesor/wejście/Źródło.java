package procesor.wejście;

import com.restfb.json.*;
import static com.restfb.json.Json.*;
import java.util.*;

/**
 *
 * @author Grzesiek
 */
public class Źródło {    
    private TreeSet<Facebook> profile = new TreeSet<>();
    private Facebook f1 = new Facebook();
    private Facebook f2 = new Facebook();    
    private Facebook f3 = new Facebook();
    private Facebook f4 = new Facebook();
    private Facebook f5 = new Facebook();    
        
    public Źródło() {   
        inicjalizuj();
    }
    
    private void inicjalizuj() {
        f1.add("id", "1");
        f1.add("birthday", 401280850089l);        
        f1.add("firstname", "Luna");
        f1.add("lastname", "Kling");        
        f1.add("occupation", "Direct Applications Administrator");       
        f1.add("gender", "female");
        f1.add("city", new JsonObject().add("countryName", "United Kingdom").add("cityName", "London").add("stateName", "England").add("coords", new JsonObject().add("lon", -0.12574).add("lat", 51.50853)));
        f1.add("work", "Lebsack - Rippin");          
        f1.add("friends", new JsonArray().add("68")
                                         .add("38")
                                         .add("122")
                                         .add("115")
                                         .add("127")
                                         .add("128")
                                         .add("91")
                                         .add("82")
                                         .add("31")
                                         .add("53")
                                         .add("32")
                                         .add("65")
                                         .add("76")
                                         .add("87"));        
        f1.add("school", "Walter, Cartwright and Jerde");
        f1.add("location", "London");          
        f1.add("relationship", "Married");        
        f1.add("posts", new JsonArray().add(new JsonObject().add("id", "1").add("message", "Beautiful picture. Curve is nice if you sit within The radius. Nice interface. Enjoyable to watch TV and YouTube as well Netflix. Like the voice recognition software."))
                                       .add(new JsonObject().add("id", "2").add("message", "What a great picture, what great sound.! No more glare.!!!! I love this TV. I bought this on for $1299.00 the Sunday before black Friday. Have only seen it on sale for $1499.00 since then. All the apps were very intimidating at first but I got used to them very fast. Sometimes I feel as though I have my theater system on, that's how good the sound is. The easiest part was setting it up. Took 30 minutes and I was watching TV. I'm still reading the manual. Can't say enough good things about this TV."))
                                       .add(new JsonObject().add("id", "3").add("message", "We definitely wound up with buyers remorse once we got it home and set up. Yes, it is that fraction of a step up from the 55 inch Samsung we purchased a few years ago, but truly, just a fraction better. It is not that WOW you want to yell once you spend twice as much as the same size new best in class TVs that are not the OLED. We definitely go by the new TV's now and just shake our heads at our mistake. Not mad about it, just disappointed in ourselves.")));          
        profile.add(f1);

        f2.add("id", "2");
        f2.add("birthday", 401280850089l);        
        f2.add("firstname", "Kuna");
        f2.add("lastname", "Matata");        
        f2.add("occupation", "Direct Applications Administrator");       
        f2.add("gender", "female");
        f2.add("city", new JsonObject().add("countryName", "United Kingdom").add("cityName", "London").add("stateName", "England").add("coords", new JsonObject().add("lon", -0.12574).add("lat", 51.50853)));
        f2.add("work", "Lebsack - Rippin");          
        f2.add("friends", new JsonArray().add("68")
                                         .add("38")
                                         .add("122")
                                         .add("115")
                                         .add("127")
                                         .add("128")
                                         .add("91")
                                         .add("82")
                                         .add("31")
                                         .add("53")
                                         .add("32")
                                         .add("65")
                                         .add("76")
                                         .add("87"));        
        f2.add("school", "Walter, Cartwright and Jerde");
        f2.add("location", "London");          
        f2.add("relationship", "Married");        
        f2.add("posts", new JsonArray().add(new JsonObject().add("id", "11").add("message", " love this tv. I was going to purchase a 55 inch but saw this 48 inch. It's perfect for me. I love the features on it and the different things you can do on it. The apps available to you as well as your own downloaded apps. I was surprised it came with 3d. I ordered some 3d movies and have watched a few and the picture is clear. The only thing is that there was no instructions for the 3d glasses."))
                                       .add(new JsonObject().add("id", "12").add("message", "Great picture detail, resolution. Works faster and smarter than our older 1080p TV. Love the upscale that this TV includes...until we get more content. Love the point/laser style remote control. Works faster than scrolling up/down/sideways. If you want a top of the line TV, this one is awesome!"))
                                       .add(new JsonObject().add("id", "13").add("message", "I have always had Vizio televisions but after I saw my father's Samsung I knew I had to have one! Love the curve, it's so gentle on the eyes.")));   
        profile.add(f2);    
        
        f3.add("id", "3");
        f3.add("birthday", 401280850089l);        
        f3.add("firstname", "Pora");
        f3.add("lastname", "Kawowa");        
        f3.add("occupation", "Direct Applications Administrator");       
        f3.add("gender", "female");
        f3.add("city", new JsonObject().add("countryName", "United Kingdom").add("cityName", "London").add("stateName", "England").add("coords", new JsonObject().add("lon", -0.12574).add("lat", 51.50853)));
        f3.add("work", "Lebsack - Rippin");          
        f3.add("friends", new JsonArray().add("68")
                                         .add("38")
                                         .add("122")
                                         .add("115")
                                         .add("127")
                                         .add("128")
                                         .add("91")
                                         .add("82")
                                         .add("31")
                                         .add("53")
                                         .add("32")
                                         .add("65")
                                         .add("76")
                                         .add("87"));        
        f3.add("school", "Walter, Cartwright and Jerde");
        f3.add("location", "London");          
        f3.add("relationship", "Married");        
        f3.add("posts", new JsonArray().add(new JsonObject().add("id", "21").add("message", "Pretty spendy tv. But was worth it. Amazing picture and opoptions. You just gotta know how to use them and get th best out of it."))
                                       .add(new JsonObject().add("id", "22").add("message", "here isn't much for me to say negative about this set but maybe a few things: one, connecting a regular coaxial to the back port of the unit is a pain because of the design choice that leaves very little wiggle room, so I only recommend using HDMI for everything HD. Two, I noticed while watching certain older shows or fast animation, particularly with 3D on, this TV does exhibit a little afterimage, but after a while you will ignore it or will have to make picture adjustments to solve the problem. I recommend adjusting the picture settings to turn off smoothing or some other digital picture option to alleviate this. (This wasn't for everything, mind you.) Third, the important one of it all, of course was price. $3,500 is expensive for a lot of people. Try to catch this beast while it is on sale."))
                                       .add(new JsonObject().add("id", "23").add("message", "When it came to getting a new tv I was torn between this OLED or a 4K LED tv. One thing that has always bothered me about LED tvs is that on dark scenes in movies you can see the edge lighting. With OLED you do not have this issue since every pixel is individually lit. I know they do make some new 4k LED tvs now with backlighting instead of edge lighting; however, even these did not look as good to me as this OLED. When you compare the sharpness, contrast, and just the overall picture quality I just could not find a tv that could come close to this OLED.")));   
        profile.add(f3);    
        
        f4.add("id", "4");
        f4.add("birthday", 401280850089l);        
        f4.add("firstname", "Adam");
        f4.add("lastname", "Janus");        
        f4.add("occupation", "Direct Applications Administrator");       
        f4.add("gender", "female");
        f4.add("city", new JsonObject().add("countryName", "United Kingdom").add("cityName", "London").add("stateName", "England").add("coords", new JsonObject().add("lon", -0.12574).add("lat", 51.50853)));
        f4.add("work", "Lebsack - Rippin");          
        f4.add("friends", new JsonArray().add("68")
                                         .add("38")
                                         .add("122")
                                         .add("115")
                                         .add("127")
                                         .add("128")
                                         .add("91")
                                         .add("82")
                                         .add("31")
                                         .add("53")
                                         .add("32")
                                         .add("65")
                                         .add("76")
                                         .add("87"));        
        f4.add("school", "Walter, Cartwright and Jerde");
        f4.add("location", "London");          
        f4.add("relationship", "Married");        
        f4.add("posts", new JsonArray().add(new JsonObject().add("id", "31").add("message", "Owned it two months and still haven't used all the features! The pictures is absolutely amazing! All the Smart TV services are overwhelming! Spectacular center piece for our new living room!"))
                                       .add(new JsonObject().add("id", "32").add("message", "was created to help with debugging. As JSON data is often output without line breaks to save space, it is extremely difficult to actually read and make sense of it. This little tool hoped to solve the problem by formatting the JSON data so that it is easy"))
                                       .add(new JsonObject().add("id", "33").add("message", "JSON or JavaScript Object Notation is a language-independent open data format that uses human-readable text to express data objects consisting of attribute-value pairs.")));   
        profile.add(f4);  
        
        f5.add("id", "5");
        f5.add("birthday", 401280850089l);        
        f5.add("firstname", "Pablo");
        f5.add("lastname", "Kos");        
        f5.add("occupation", "Direct Applications Administrator");       
        f5.add("gender", "female");
        f5.add("city", new JsonObject().add("countryName", "United Kingdom").add("cityName", "London").add("stateName", "England").add("coords", new JsonObject().add("lon", -0.12574).add("lat", 51.50853)));
        f5.add("work", "Lebsack - Rippin");          
        f5.add("friends", new JsonArray().add("68")
                                         .add("38")
                                         .add("122")
                                         .add("115")
                                         .add("127")
                                         .add("128")
                                         .add("91")
                                         .add("82")
                                         .add("31")
                                         .add("53")
                                         .add("32")
                                         .add("65")
                                         .add("76")
                                         .add("87"));        
        f5.add("school", "Walter, Cartwright and Jerde");
        f5.add("location", "London");          
        f5.add("relationship", "Married");        
        f5.add("posts", new JsonArray().add(new JsonObject().add("id", "41").add("message", "My husband wanted to buy the Samsung 4K curve tv against my preference (we are traditionally a SONY family) but I must say that it is quite exceptional and the picture is undeniably real. I can safely say after one month, I am spoiled and know I will have difficulty watching anything else!"))
                                       .add(new JsonObject().add("id", "42").add("message", "Owned it two months and still haven't used all the features! The pictures is absolutely amazing! All the Smart TV services are overwhelming! Spectacular center piece for our new living room!"))
                                       .add(new JsonObject().add("id", "43").add("message", "I like this curve even I'm sitting on the side and I can still see it as if I'm in front of my tv. Hope they lower the price so I can by for my loft")));   
        profile.add(f5);        
    }    
    
    public TreeSet<Facebook> pobierzProfile() {
        return profile;
    }
}
