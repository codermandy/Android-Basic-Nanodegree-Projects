package com.example.android.justjava;
/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int coffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + coffee);
    }

    /*
     * This method increments the given quantity value on the screen.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "Too many cups of Coffee!", Toast.LENGTH_LONG).show();
            return;
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method decrements the given quantity value on the scereen.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Too few cups of Coffee!", Toast.LENGTH_LONG).show();
            return;
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /*
    *Defines Email method for sending the email
     */
    public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrders(View view) {
        /*
        *Checks status of whipped cream checkbox
         */
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        boolean haswhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity","the Coffee contains WhippedCream "+whippedCreamCheckBox);
        /*
        * Checks status of chocolate checkbox
         */
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        /*
        * Inputs the name and stores in string variable
         */
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        name = nameEditText.getText().toString();
        /*
        * Total price of the coffee along with toppings.
         */
        int basePrice = 5;
        //Add $2 if chocolate
        if (hasChocolate) {
            basePrice = basePrice + 2;
        }
        //Add $1 if whipped cream
        if (haswhippedCream) {
            basePrice = basePrice + 1;
        }
        int totalPrice = basePrice;
        /*
        * Displays the message to be viewed on the screen
         */
        String msg = createOrderSummary(totalPrice, haswhippedCream, hasChocolate, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

//        displayMessage(msg);

        }
    }
    /**
     * Creates summary of order
     *
     * @param price           of order
     * @param addWhippedCream checkbox
     * @param addChocolate    Checkbox
     * @param addName         Name of customer
     * @return summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String addName) {
        String summary = "Name: " + addName;
        summary += "\nAdd whipped Cream? " + addWhippedCream;
        summary += "\nAdd Chocolate? " + addChocolate;
        summary += "\nQuantity:" + quantity;
        summary += "\nTotal Rs:" + quantity * price;
        summary += "\nThank you!";
        return summary;

    }


}
