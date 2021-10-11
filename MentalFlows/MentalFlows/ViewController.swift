//
//  ViewController.swift
//  MentalFlows
//
//  Created by Alexander Hawkins on 10/2/21.
//

import UIKit //import UIKit

class ViewController: UIViewController //Class named ViewController set to UIViewController
{
    // let and var variables
    
    var readings = Readings(); //Var named readings set to the function Readings from ReadingsTab.swift
    
    var HeartFilled: Bool = false //Var named HeartFilled set to false (Not filled)
    
    let heartImgUnfill = UIImage(named: "HeartUnfilled") //Let named heartImgUnfill set to the HearUnfilled image
    
    let heartImgFill = UIImage(named: "HeartFilled") //Let named heartImgFill set to the HeartFilled image
    
    
    //IBOutlets
    
    @IBOutlet weak var Quotes: UILabel! //IBOutlet connection for the Quotes label.
    
    @IBOutlet weak var Authors: UILabel! //IBOutlet connection for the Authors label.
    
    
    @IBOutlet weak var heartBtn: UIButton! //IBOutlet connection for the Heart Button.
    
    
    // Function for the Left Button
    
    @IBAction func LeftBtn(_ sender: UIButton) //IBAction function named LeftBtn with a UIButton perameter.
    {
        if readings.arrayIndex > 0 //Base case
        {
            readings.arrayIndex = readings.arrayIndex - 1 //Set arrayIndex - 1 to display the previous content
        }
        
        Quotes.text = readings.quotesContent[readings.arrayIndex] //Display the Quote that is at the current array.
        Authors.text = readings.authorsContent[readings.arrayIndex] //Display the Author that is at the current array.
        
        //heartBtn.setImage(heartImgUnfill, for: .normal)
        //HeartFilled = false;
        
        if readings.HeartOnOff[readings.arrayIndex] == true //if the HeartOnOff index is true
        {
            heartBtn.setImage(heartImgFill, for: .normal) //Set the image to fill
            HeartFilled = true; //Set HeartFilled to true
        }
        
        else //else
        {
            heartBtn.setImage(heartImgUnfill, for: .normal) //Set the image to unfill
            HeartFilled = false; //Set HeartFilled to false
            
        }
    }
    
    //Function for the Right Button
    
    @IBAction func RightBtn(_ sender: UIButton)
    {
        if readings.arrayIndex < (readings.quotesContent.count - 1) //Base case
        {
            readings.arrayIndex = readings.arrayIndex + 1 //Set arrayIndex + 1 to display the next content
        }
        
        Quotes.text = readings.quotesContent[readings.arrayIndex] //Display the Quote that is at the current array.
        Authors.text = readings.authorsContent[readings.arrayIndex] //Display the Author that is at the current array.
        
        //heartBtn.setImage(heartImgUnfill, for: .normal)
        //HeartFilled = false;
        
        if readings.HeartOnOff[readings.arrayIndex] == true //if the HeartOnOff index is true
        {
            heartBtn.setImage(heartImgFill, for: .normal) //Set the image to fill
            HeartFilled = true; //Set HeartFilled to true
        }
        
        else //else
        {
            heartBtn.setImage(heartImgUnfill, for: .normal) //Set the image to unfill
            HeartFilled = false; //Set HeartFilled to false
            
        }
        
    }
    
    
    // Heart Button: Portion of code provided by Mohammed Drame <https://mdrame113.medium.com/change-uibutton-image-on-click-77107a681ef7>
    
    
    @IBAction func HeartChange(_ sender: UIButton)
    {
        HeartFilled.toggle() //Utilizing the toggle() function (apple doc) to switch from false/true to true/false
        
        setBtnBackground(view: sender, on: #imageLiteral(resourceName: "HeartFilled"), off: #imageLiteral(resourceName: "HeartUnfilled"), onOffStatus: HeartFilled) //Calling setBtnBackground function to set the state of the image button to either a filled heart or unfilled.
    }
    
    func setBtnBackground(view: UIButton, on: UIImage, off: UIImage, onOffStatus: Bool) //Creating a function named setBtnBackground with 4 perameters (view, on, off, onOffStatus) to change the UIImage
    {
        switch onOffStatus //Created a switch statement named onOffStatus
        {
            case true: //if onOffStatus is true
                
                readings.HeartOnOff[readings.arrayIndex] = true //Set the HeartOnOff index as true
                
                view.setImage(on, for: .normal) //set the view image to a filled heart
                print("Heart Filled") //Print "Heart Filled" to the terminal
                
            default: //default
                
                readings.HeartOnOff[readings.arrayIndex] = false //Set the HeartOnOff index as false
                
                view.setImage(off, for: .normal) //set the view image to an unfilled heart
                print("Heart Unfilled") //Print "Heart Unfilled" to the terminal
        }
        
    }
    
    
    
    
    
    
    //Share Button
    
    @IBAction func ShareBtn(_ sender: Any) //Portion of code provided by Vasil Blanco-Nunev <https://www.youtube.com/watch?v=do1EF3CoO8M>
    {
        let shareActivity = UIActivityViewController(activityItems: [readings.quotesContent[readings.arrayIndex], readings.authorsContent[readings.arrayIndex]], applicationActivities: nil); //Let named shareActivity set to UIActivityViewController with perameters activityItems and applicationActivites. activityItems stores the content of the quote and author the user wants to share.
        
        shareActivity.popoverPresentationController?.sourceView = self.view; //The controller is presented as a popover.
        
        self.present(shareActivity, animated: true, completion: nil); //When the user clicks the button, the popup window will appear and the user will click where the content wants to be shared.
    }
    
    
    
    
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

