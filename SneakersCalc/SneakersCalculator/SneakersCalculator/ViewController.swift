//
//  ViewController.swift
//  SneakersCalculator
//
//  Created by Alexander Hawkins on 9/23/21.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate
{

    
    @IBOutlet weak var SneakersAmt: UITextField!;
    
    
    @IBOutlet weak var TipPercentage: UITextField!;
    
    
    @IBOutlet weak var QuantityLabel: UILabel!;
    
    
    
    @IBOutlet weak var QuantityStepper: UIStepper!;
    
    
    
    @IBOutlet weak var TipDue: UILabel!;
    
    
    @IBOutlet weak var TotalDue: UILabel!;
    
    
    
    
    
    @IBAction func UpdateQuantity(_ sender: UIStepper)
    {
        if QuantityStepper.value == 1
        {
            QuantityLabel.text = "1 sneaker";
        }
        
        else
        {
            QuantityLabel.text = String(format: "%.0f", QuantityStepper.value) + " sneakers";
        }
        
        updateTipTotals();
    }
    
    
    
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool
    {
        textField.resignFirstResponder();
        return true;
    }
    
    
    
    
    
    func updateTipTotals()
    {
        var amount: Float; //Check the amount
        var tipPct: Float; //Tip Percentage
        
        if SneakersAmt.text!.isEmpty
        {
            amount = 0.0;
        }
        
        else
        {
            amount = Float(SneakersAmt.text!)!;
        }
        
        if TipPercentage.text!.isEmpty
        {
            tipPct = 0.0;
        }
        
        else
        {
            tipPct = Float(TipPercentage.text!)!/(100);
        }
        
        let tip = amount * tipPct;
        let total = amount + tip;
        let currencyFormatter = NumberFormatter();
        let numberOfSneakers = QuantityStepper.value;
        var sneakerTotal : Float = 0.0;
        
        if numberOfSneakers > 0
        {
            sneakerTotal = (total * Float(numberOfSneakers));
        }
        
        else
        {
            let alert=UIAlertController(title: "Warning", message: "The number of sneakers must be greater than 0", preferredStyle: UIAlertController.Style.alert)
            
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            
            let okAction=UIAlertAction(title: "OK", style: UIAlertAction.Style.default, handler: {action in
               self.QuantityStepper.value = 1
                self.QuantityLabel.text? = "1 sneaker"
                self.updateTipTotals()
        })
            
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        currencyFormatter.numberStyle = NumberFormatter.Style.currency; //Set the number style
        
        TipDue.text = currencyFormatter.string(from: NSNumber(value: tip)); //Returns a formatted string
        
        TotalDue.text = currencyFormatter.string(from: NSNumber(value: sneakerTotal));
        
        
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTipTotals();
    }
    
    
    
    
    
    
    
    
    
    override func viewDidLoad()
    {
        SneakersAmt.delegate = self;
        TipPercentage.delegate = self;
        
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

